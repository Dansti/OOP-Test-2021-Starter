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

	public void setUp() 
	{
		loadScore();
		printScores();
	}

	public void draw()
	{
		int j=0;
		background(255);
		fill(0);
		textSize(40);
		textAlign(RIGHT);

		for(int i=0;i<score.length();i++)
		{
			char check = score.charAt(i);
			if(Character.isLetter(check))
			{
				j++;
				text(check,width/12+50*j,height/2-100);
			}
		}

		for(int i=0;i<5;i++)
		{
			line(width/12,height/2+50*i,width-width/12,height/2+50*i);
		}
		
	}

	public void drawNotes()
	{
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
		System.out.print(notes);
	}

	public class Note
	{
		private char note;
		private int duration;

		public Note(char n, int d)
		{
			this.note = n;
			this.duration = d;
		}

		public String toString()
		{
			String qc;
			if(duration == 1)
			{	
				qc = "Quaver";
			}
			else
			{
				qc = "Crotchet";
			}
			return "\n" + note + " " + duration + " " + qc + " " + "\n";
		}
	}

}
