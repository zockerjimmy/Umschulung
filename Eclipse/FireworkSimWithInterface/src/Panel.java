import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Panel extends JPanel
{
	//########################################GLOBAL###############################################
	
	final static int WINDOW_WIDTH = 1800;
	final static int WINDOW_HEIGHT = 800;
	final static Rectangle rCanvas = new Rectangle(0, 0, (int) (WINDOW_WIDTH * 0.8), WINDOW_HEIGHT);

	//#############################################################################################
	
	private int actualFrame;

	private Timer timer;
	private ActionListener listenerTime;

	private ArrayList<Particle> particle = new ArrayList<Particle>();

	//##################################PURE GUI VARIABLES##########################################
	
	//Rectangles zur Positionierung
	private Rectangle rControl, rInputPos, rInputAttr;

	//Buttons
	private JButton btnStart, btnStop;
	private Point btnStartPos, btnStopPos;

	//Textfields
	protected JTextField inputPosXText, inputRadiusText, inputAccelerationText, inputGravityText;
	protected Point inputPosXTextPos, inputRadiusTextPos, inputAccelerationTextPos, inputGravityTextPos;

	//Labels
	private JLabel labelPosition, labelPositionX, labelAttr, labelAcceleration, labelRadius, labelGravity;
	private Point labelPositionPos, labelPositionXPos, labelAttrPos, labelAccelerationPos, labelRadiusPos,
			labelGravityPos;
	
	//##############################################################################################
	
	public Panel()
	{
		this.actualFrame = 0;
		this.rControl = new Rectangle(rCanvas.width, 0, WINDOW_WIDTH - rCanvas.width, WINDOW_HEIGHT);
		this.rInputPos = new Rectangle((int) (this.rControl.x * 1.005), (int) (this.rControl.height * 0.08),
				(int) (this.rControl.width * 0.165), (int) (this.rControl.height * 0.05));
		this.rInputAttr = new Rectangle((int) (this.rInputPos.x + this.rInputPos.width),
				(int) (this.rControl.height * 0.08), (int) (this.rControl.width * 0.8),
				(int) (this.rControl.height * 0.05));
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setFocusable(true);
		AddListenerTime();
		this.timer = new Timer(25, listenerTime);
		CreateButtons();
		CreateLabels();
		CreateTextfields();
	}

	public void CreateButtons()
	{
		this.btnStart = new JButton("Start Simulation");
		this.btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				particle.add(new Particle(Integer.parseInt(inputPosXText.getText()),
						Integer.parseInt(inputRadiusText.getText()),
						Double.parseDouble(inputAccelerationText.getText()),
						Double.parseDouble(inputGravityText.getText())));
				timer.restart();
			}
		});
		this.add(btnStart);
		this.btnStart.setBounds(0, 0, 0, 27);
		this.btnStart.setLocation((int) (this.rControl.x * 1.075), (int) (this.rControl.height * 0.025));
		this.btnStartPos = this.btnStart.getLocation();
		//this.btnStartHeight = this.btnStart.getHeight();

		this.btnStop = new JButton("Stop Simulation");
		this.btnStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				timer.stop();
			}
		});
		this.add(btnStop);
		this.btnStop.setBounds(0, 0, 0, 27);
		this.btnStop.setLocation((int) (this.rControl.x * 1.075), (int) (this.rControl.height * 0.95));
		this.btnStopPos = this.btnStop.getLocation();
		//this.btnStopHeight = this.btnStop.getHeight();
	}

	public void SetButtons()
	{
		this.btnStart.setLocation(this.btnStartPos);
		this.btnStop.setLocation(this.btnStopPos);
	}

	public void CreateLabels()
	{
		this.labelPosition = new JLabel("Position:");
		this.labelPositionX = new JLabel("X: ");
		this.labelAttr = new JLabel("Attribute:");
		this.labelRadius = new JLabel("Radius: ");
		this.labelAcceleration = new JLabel("Acceleration: ");
		this.labelGravity = new JLabel("Gravity: ");

		this.add(this.labelPosition);
		this.add(this.labelPositionX);
		this.add(this.labelAttr);
		this.add(this.labelRadius);
		this.add(this.labelAcceleration);
		this.add(this.labelGravity);

		this.labelPosition.setLocation((int) (this.rInputPos.x + 5), (int) (this.rInputPos.y));
		this.labelPositionX.setLocation((int) (this.rInputPos.x + 5), (int) (this.rInputPos.y * 1.33));
		this.labelAttr.setLocation((int) (this.rInputAttr.x + 5), (int) (this.rInputAttr.y));
		this.labelRadius.setLocation((int) (this.rInputAttr.x + 5), (int) (this.rInputAttr.y * 1.33));
		this.labelAcceleration.setLocation((int) (this.rInputAttr.x * 1.055), (int) (this.rInputAttr.y * 1.33));
		this.labelGravity.setLocation((int) (this.rInputAttr.x * 1.128), (int) (this.rInputAttr.y * 1.33));

		this.labelPositionPos = this.labelPosition.getLocation();
		this.labelPositionXPos = this.labelPositionX.getLocation();
		this.labelAttrPos = this.labelAttr.getLocation();
		this.labelRadiusPos = this.labelRadius.getLocation();
		this.labelAccelerationPos = this.labelAcceleration.getLocation();
		this.labelGravityPos = this.labelGravity.getLocation();
	}

	public void SetLabels()
	{
		this.labelPosition.setLocation(this.labelPositionPos);
		this.labelPositionX.setLocation(this.labelPositionXPos);
		this.labelAttr.setLocation(this.labelAttrPos);
		this.labelRadius.setLocation(this.labelRadiusPos);
		this.labelAcceleration.setLocation(this.labelAccelerationPos);
		this.labelGravity.setLocation(this.labelGravityPos);
	}

	public void CreateTextfields()
	{
		this.inputPosXText = new JTextField("0", 3);
		this.inputRadiusText = new JTextField("10", 2);
		this.inputAccelerationText = new JTextField("20", 2);
		this.inputGravityText = new JTextField("-0.25", 3);

		this.add(this.inputPosXText);
		this.add(this.inputRadiusText);
		this.add(this.inputAccelerationText);
		this.add(this.inputGravityText);

		this.inputPosXText.setLocation((int) (this.labelPositionXPos.x + 15), (int) (this.rInputPos.y * 1.3));
		this.inputRadiusText.setLocation((int) (this.labelRadiusPos.x * 1.03), (int) (this.rInputAttr.y * 1.3));
		this.inputAccelerationText.setLocation((int) (this.labelAccelerationPos.x * 1.05),
				(int) (this.rInputAttr.y * 1.3));
		this.inputGravityText.setLocation((int) (this.labelGravityPos.x * 1.027), (int) (this.rInputAttr.y * 1.3));

		this.inputPosXTextPos = this.inputPosXText.getLocation();
		this.inputRadiusTextPos = this.inputRadiusText.getLocation();
		this.inputAccelerationTextPos = this.inputAccelerationText.getLocation();
		this.inputGravityTextPos = this.inputGravityText.getLocation();

		this.inputPosXText.setToolTipText("If '0' then x will assigned a random value");
	}

	public void SetTextfields()
	{
		this.inputPosXText.setLocation(this.inputPosXTextPos);
		this.inputRadiusText.setLocation(this.inputRadiusTextPos);
		this.inputAccelerationText.setLocation(this.inputAccelerationTextPos);
		this.inputGravityText.setLocation(this.inputGravityTextPos);
	}

	public void Repaint()
	{
		this.repaint();
	}

	public void AddListenerTime()
	{
		listenerTime = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Repaint();
				if (actualFrame >= 40)
				{
					if (Math.random() <= 1)
					{
						particle.add(new Particle(Integer.parseInt(inputPosXText.getText()),
								Integer.parseInt(inputRadiusText.getText()),
								Double.parseDouble(inputAccelerationText.getText()),
								Double.parseDouble(inputGravityText.getText())));
					}
					actualFrame = 0;
				}
				else actualFrame++;
			}
		};
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// g.drawRect(this.rCanvas.x, this.rCanvas.y, this.rCanvas.width,
		// this.rCanvas.height);
		if (this.particle != null)
		{
			for (Particle p : this.particle)
			{
				p.Update();
				p.Show(g);
			}
		}
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.rControl.x, this.rControl.y, this.rControl.width, this.rControl.height);
		g.setColor(Color.GRAY);
		g.fillRect(this.rInputPos.x, this.rInputPos.y, this.rInputPos.width, this.rInputPos.height);
		g.fillRect(this.rInputAttr.x, this.rInputAttr.y, this.rInputAttr.width, this.rInputAttr.height);
		g.setColor(Color.BLACK);
		SetButtons();
		SetLabels();
		SetTextfields();
	}
}
