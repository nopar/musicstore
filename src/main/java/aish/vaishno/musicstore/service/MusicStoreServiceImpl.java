/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.service;

import aish.vaishno.musicstore.dao.IMusicStoreDao;
import aish.vaishno.musicstore.pojo.MusicDetails;
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

    @Override
    public String addSong(MusicDetails musicDetails) {
        return musicStoreDao.addSong(musicDetails);
    }

    @Override
    public List<MusicDetails> getSongList() {
        return musicStoreDao.getSongList();
    }

 }
