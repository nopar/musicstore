/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.dao;


import aish.vaishno.musicstore.manager.HibernateSessionManager;
import aish.vaishno.musicstore.pojo.MusicDetails;
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
    public String addSong(MusicDetails musicDetails) {
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
    public List<MusicDetails> getSongList() {
      SessionFactory sessionFactory=HibernateSessionManager.getSessionFactory();
      Session session=sessionFactory.getCurrentSession();
      Transaction transaction=session.beginTransaction();
      try{
        transaction.begin();
        List<MusicDetails> songList=session.createQuery("from MusicDetails").list();
        return songList;
      }finally{
        session.close();
      }
   }

  }
