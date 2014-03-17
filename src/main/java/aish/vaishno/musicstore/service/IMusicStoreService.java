/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.service;

import aish.vaishno.musicstore.pojo.MusicDetail;
import java.util.List;

/**
 *
 * @author Aishu
 */
public interface IMusicStoreService {
    
    public String addSong(MusicDetail musicDetail);
    public List<MusicDetail> getSongList();
    
    /**/
        public void updateSong(MusicDetail musicDetail);
	public MusicDetail getSong(int musicID);
	public void deleteSong(int musicID);
   
}
