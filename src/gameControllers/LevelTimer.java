package gameControllers;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.Timer;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.event.MouseInputAdapter;

import entity.Board;
import entity.BoardBoss;
import entity.BullPen;
import entity.Hexomino;
import entity.Tile;
import views.Level;


public class LevelTimer{
	static Timer timer;
	
	
	public static void main(final Level level) throws Exception{
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(level.gameType=="Lightning Level") {
            		if(level.levelTime>0) {
            			level.levelTime-=1;
            		}
            		if(level.levelTime == 0){
            			timer = null;
            		}
            		
            	}
            	level.setLabel();
            }
        };
        if(timer == null)
        	timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();


    }





}

