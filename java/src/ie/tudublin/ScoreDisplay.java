package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList <Note> notes;
	
	public void settings()
	{
		size(1000, 500);
	}

	public void setup() 
	{
		loadScore();
		printScores();
	}

	public void draw()
	{
		background(255);

		for(int i=0;i<5;i++)
		{
			line(width/12,height/2+50*i,width-width/12,height/2+50*i);
		}
		drawNotes();
		
	}

	public void drawNotes()
	{
		int j=0;
		fill(0);
		textSize(40);
		textAlign(RIGHT);

		for(int i=0;i<score.length();i++)
		{
			colorMode(RGB);
			char check = score.charAt(i);
			if(Character.isLetter(check))
			{
				j++;
				if(mouseX>width/21+width/21*j && mouseY>height-height/8-10*j)
				{
					fill(255,0,0);
				}
				else
				{
					fill(0,0,0);
				}
				text(check,width/12+50*j,height/2-100);
				line(width/21+width/21*j+10,height-height/8-10*j,width/21+width/21*j+10,height-height/8-10*j-60);
				ellipse(width/21+width/21*j,height-height/8-10*j,25,25);
			}
			else
			{
				line(width/21+width/21*j+10,height-height/8-10*j-60,width/21+width/21*j+20,(height-height/8-10*j-60)+30);
			}
		}
	}

	public void loadScore()
	{
		int duration=0;
		notes = new ArrayList<>(score.length());
		for(int i=0;i<score.length();i++)
		{
			char check = score.charAt(i);
			if(Character.isLetter(check))
			{
				if(score.length()-1>i)
				{
					if(Character.isDigit(score.charAt(i+1)))
					{
						duration = score.charAt(i+1)-'0';
					}
					else
					{
						duration = 1;
					}
				}
				notes.add(new Note(check,duration));
			}
		}
	}

	public void printScores()
	{
		System.out.print(notes.toString());
	}

	public class Note
	{
		private char note;
		private int duration;
		String qc;

		public Note(char n, int d)
		{
			this.note = n;
			this.duration = d;
		}

		public String toString()
		{
			if(duration == 1)
			{	
				qc = "Quaver";
			}
			else
			{
				qc = "Crotchet";
			}
			
			return "\n" + note + " " + duration + " " + qc + "\n";
		}
	}
}
