package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenu extends MouseAdapter {

	public boolean active;

	private Rectangle play1Btn; 
	private String play1Txt = "Player 1";
	private boolean p1Highlight = false; 

	
	private Rectangle play2Btn; 
	private String play2Txt = "Player 2";
	private boolean p2Highlight = false; 

	private Font font;

	/**
	 * constructor
	 * 
	 */
	public MainMenu(Game game) {

		active = true;
		game.start();

		// position and dimensions of each button
		int x, y, w, h;

		w = 300;
		h = 150;

		y = Game.HEIGHT / 2 - h / 2;

		x = Game.WIDTH / 4 - w / 2;
		play1Btn = new Rectangle(x, y, w, h);

		x = Game.WIDTH * 3 / 4 - w / 2;
		play2Btn = new Rectangle(x, y, w, h);

		font = new Font("Roboto", Font.PLAIN, 80);
	}


	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setFont(font);

		// draw buttons
		g.setColor(Color.black);
		if (p1Highlight)
			g.setColor(Color.white);
		g2d.fill(play1Btn);

		g.setColor(Color.black);
		if (p2Highlight)
			g.setColor(Color.white);
		g2d.fill(play2Btn);

		// draw button borders
		g.setColor(Color.white);
		g2d.draw(play1Btn);
		g2d.draw(play2Btn);

		// draw text in buttons

		int strWidth, strHeight;

		
		strWidth = g.getFontMetrics(font).stringWidth(play1Txt);
		strHeight = g.getFontMetrics(font).getHeight();

		g.setColor(Color.green);
		g.drawString(play1Txt, (int) (play1Btn.getX() + play1Btn.getWidth() / 2 - strWidth / 2),
				(int) (play1Btn.getY() + play1Btn.getHeight() / 2 + strHeight / 4));

		
		strWidth = g.getFontMetrics(font).stringWidth(play2Txt);
		strHeight = g.getFontMetrics(font).getHeight();

		g.setColor(Color.red);
		g.drawString(play2Txt, (int) (play2Btn.getX() + play2Btn.getWidth() / 2 - strWidth / 2),
				(int) (play2Btn.getY() + play2Btn.getHeight() / 2 + strHeight / 4));

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Point p = e.getPoint();

		if (play1Btn.contains(p))
			active = false;
		else if (play2Btn.contains(p))
			active = false;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		Point p = e.getPoint();

		// determine if mouse is hovering inside one of the buttons
		p1Highlight = play1Btn.contains(p);
		p2Highlight = play2Btn.contains(p);

	}

}
