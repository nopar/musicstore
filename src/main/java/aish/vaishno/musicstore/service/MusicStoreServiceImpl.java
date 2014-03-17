/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.service;

import aish.vaishno.musicstore.dao.IMusicStoreDao;
import aish.vaishno.musicstore.pojo.MusicDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aishu
 */
@Service
public class MusicStoreServiceImpl implements IMusicStoreService{
    
    @Autowired
    private IMusicStoreDao musicStoreDao;

    
    public String addSong(MusicDetail musicDetails) {
        return musicStoreDao.addSong(musicDetails);
    }

  
    public List<MusicDetail> getSongList() {
        return musicStoreDao.getSongList();
    }
    
    /**/
    public void updateSong(MusicDetail musicDetails) {
        musicStoreDao.updateSong(musicDetails);
    }

    
   
    public MusicDetail getSong(int musicID) {
        return musicStoreDao.getSong(musicID);
    }

    
    
    public void deleteSong(int musicID) {
        musicStoreDao.deleteSong(musicID);
    }

 }
