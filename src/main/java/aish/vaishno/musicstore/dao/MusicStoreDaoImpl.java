/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.dao;


import aish.vaishno.musicstore.manager.HibernateSessionManager;
import aish.vaishno.musicstore.pojo.MusicDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aishu
 */
@Service
public class MusicStoreDaoImpl implements IMusicStoreDao{
    
    @Override
    public String addSong(MusicDetail musicDetails) {
        SessionFactory sessionFactory= HibernateSessionManager.getSessionFactory();
        System.out.println("session Factory: "+sessionFactory);
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            transaction.begin();
            session.save(musicDetails);
            session.flush();
            transaction.commit();
            return "Music Details has been entered";
        }catch(HibernateException hb){
            transaction.rollback();
            System.err.println("error"+hb);
            return "Sorry some problem has occured. Try Again";
        }finally{
            session.close();
        }
    }
     
    
    @Override
    public List<MusicDetail> getSongList() {
      SessionFactory sessionFactory=HibernateSessionManager.getSessionFactory();
      Session session=sessionFactory.getCurrentSession();
      Transaction transaction=session.beginTransaction();
      try{
        transaction.begin();
        List<MusicDetail> songList=session.createQuery("from MusicDetails").list();
        return songList;
      }finally{
        session.close();
      }
   }
    
    
     /*ja som to robil*/
       public void updateSong(MusicDetail musicDetail) {
           SessionFactory sessionFactory=HibernateSessionManager.getSessionFactory();
            Session session=sessionFactory.getCurrentSession();
            Transaction transaction=session.beginTransaction();

          MusicDetail songToUpdate = getSong(musicDetail.getMusicID());
          songToUpdate.setMusicLanguage(musicDetail.getMusicLanguage());
          songToUpdate.setMusicType(musicDetail.getMusicType());
          songToUpdate.setSongName(musicDetail.getSongName());
          session.update(songToUpdate);
    }
        
        
        public MusicDetail getSong(int musicID) {
            SessionFactory sessionFactory=HibernateSessionManager.getSessionFactory();
            Session session=sessionFactory.getCurrentSession();
            Transaction transaction=session.beginTransaction();
            
		MusicDetail song = (MusicDetail) session.get(MusicDetail.class, musicID);
		return song;
	}
        
        
        
        public void deleteSong(int musicID) {
            SessionFactory sessionFactory=HibernateSessionManager.getSessionFactory();
            Session session=sessionFactory.getCurrentSession();
            Transaction transaction=session.beginTransaction();
            
		MusicDetail song = getSong(musicID);
		if (song != null)
			session.delete(song);
	}
        
    
        /* koniec moje */

  }
