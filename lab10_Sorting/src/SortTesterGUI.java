
/**
 *  Name: zhang boen
  Assignment: Lab 10
  Title: sorting
  Course: CSCE 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 12/5/2016
  Program description: do the time of sorting
  Known Bugs: none
  Creativity: none
 */

 
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

import java.awt.* ;
import java.awt.event.* ;
import java.util.Random;

public class SortTesterGUI extends JFrame  {

    /*
     * Constants for the type of data
     */
    final String[] typeNames = {"Random", "Ascending", "Descending" } ;
    
    /*
     * Constants for the type of sort
     */
    final String[] sortNames = {"Selection", "Insertion", "Bubble", "Shell",
            "Merge", "Heap", "Quick"} ;
         
    
    
    /*
     * GUI Components 
     */
    private JTextField sizeTF ;
    private JTextField numRepsTF ;
    private JButton doitB ;
    private JComboBox sortJC, typeJC ;
    private JTextArea resultTA ;
    private ButtonGroup displayGroup ;
    private JRadioButton displayYesB, displayNoB ;
    
    /*
     * Create the GUI and Listeners
     */
    public SortTesterGUI(){
        setTitle("Sorting Analysis");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
        setLayout ( new BorderLayout()) ;
        
        JPanel nPanel = new JPanel() ;
        nPanel.setLayout( new GridLayout(5,2) ) ;
        nPanel.setBorder(BorderFactory.createTitledBorder("Set Parameters"));
        
        nPanel.add( new JLabel( "Sort Algorithm" )) ;
        sortJC = new JComboBox( sortNames ) ;         
        nPanel.add( sortJC ) ;
        
        nPanel.add( new JLabel( "Data Organization" )) ;
        typeJC = new JComboBox( typeNames ) ;         
        nPanel.add( typeJC ) ;
        
        nPanel.add( new JLabel( "Array Size" )) ;
        sizeTF = new JTextField("1000");
        nPanel.add( sizeTF ) ;
        
        //get the size
      /**  try{
        size = Integer.parseInt(sizeTF.getText());
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Exception : "+ex);
        }
        
        */
       
        
        nPanel.add(new JLabel("Number Repetitions"));
        numRepsTF = new JTextField("50");
        nPanel.add(numRepsTF);
                 
        nPanel.add( new JLabel( "Display Data" )) ;        
        displayYesB = new JRadioButton( "Yes", false ) ;
        displayNoB = new JRadioButton( "No", true ) ;
        displayGroup = new ButtonGroup() ;      
        displayGroup.add(displayYesB) ;
        displayGroup.add(displayNoB) ;
                
        JPanel inner = new JPanel () ;
        inner.setLayout(new FlowLayout() ) ;
        inner.add(displayYesB) ;
        inner.add(displayNoB) ;
        nPanel.add( inner ) ;
        add( nPanel, BorderLayout.NORTH) ;    
     
        
        JPanel cPanel = new JPanel();
        cPanel.setBorder(BorderFactory.createTitledBorder("Start Sorting"));
        doitB = new JButton("Do It") ;
        cPanel.add( doitB ) ;
        doitB.addActionListener( 
                new ActionListener() {
                    public void actionPerformed( ActionEvent e ){
                        doAnalysis()  ;
                    }
                }
        ) ;
          
        add( cPanel, BorderLayout.CENTER) ;    
        
        resultTA = new JTextArea("Results will be displayed here.") ;
		JScrollPane scroller2 = new JScrollPane (resultTA);
		scroller2.setPreferredSize(new Dimension(400,200));	
		scroller2.setBorder(BorderFactory.createTitledBorder("Display Area"));
		add(scroller2, BorderLayout.SOUTH); 
        
        
        
        pack();
        
        setVisible(true ) ;

    }//constructor
    
    /**
	 * 
	 * @param min the minimum number in the array
	 * @param max the maximum number in the array
	 * @return a random number
	 */
	private int randInt(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
    
    
    
    
    
    
    private void doAnalysis() {
    	
    	Integer myArray[] = new Integer[Integer.parseInt(sizeTF.getText())];
		Timer timer = new Timer();//initiate a timer
		int timesRun = Integer.parseInt(numRepsTF.getText());//get the number of repetitions
		double timeOfOneRun = 0.0;//time of running just one repetition
		double totalTime = 0.0;//time of running all repetitions
		double avgTime = 0.0;//average time of running a sorting algorithm
		int size=myArray.length;
		
		
		
		if (typeJC.getSelectedItem() == "Random"){
			for (int i = 0; i < myArray.length; i++){
				myArray[i] = (int)(randInt(0, Integer.parseInt(sizeTF.getText())));}
		}
		if (typeJC.getSelectedItem() == "Ascending"){
			for (int i = 0; i < size; i++){
				myArray[i] = i;
			}
		}
		if (typeJC.getSelectedItem() == "Descending"){
		
			for (int i = 0; i < myArray.length; i++){
				
				myArray[i] = size -1-i;
				
			}
	}
		//above is to create a array of data whose order is determined by the user
		
		/*
		 * Determine which sorting algorithm is used
		 */
		if (sortJC.getSelectedItem() == "Quick"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
			timer.start();
			QuickSort.sort(myArray);
			timer.stop();
			timeOfOneRun = timer.getElapsedTime();
			totalTime += timeOfOneRun;
			}
			avgTime = totalTime / timesRun;
			
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Quick sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Quick sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
		}
		
		else if (sortJC.getSelectedItem() == "Heap"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				QuickSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime += timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Heap sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Heap sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
		}
		
		else if (sortJC.getSelectedItem() == "Insertion"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				InsertionSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime = totalTime + timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Insertion sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Insertion sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
			
		}
		
		else if (sortJC.getSelectedItem() == "Bubble"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				BubbleSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime += timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Bubble sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Bubble sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
			
		}
		
		else if (sortJC.getSelectedItem() == "Merge"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				MergeSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime += timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Merge sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Merge sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
			
		}
		
		else if (sortJC.getSelectedItem() == "Selection"){
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				SelectionSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime += timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Selection sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Selection sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
			
		}
		
		else{
			if ( displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray)+ "\n");
			}
			for (int i = 0; i < timesRun; i++){
				timer = new Timer();
				timer.start();
				ShellSort.sort(myArray);
				timer.stop();
				timeOfOneRun = timer.getElapsedTime();
				totalTime += timeOfOneRun;
				}
				avgTime = totalTime / timesRun;
			
			if (displayYesB.isSelected()){
				resultTA.setText(Arrays.toString(myArray) + "\n" + "Shell sort:  array size=" + myArray.length + ", " +
	            "execution time=" + avgTime);
			}
			else {
				resultTA.setText("No array display, the resutl is:" + "\n" + "Shell sort:  array size=" + myArray.length + 
			           ", " + "execution time=" + avgTime);
			}
			//above is whether to display the sorted array
			
		}
    	    
            
        
    }
    
     
    
    /*
     * Start everything up and set the defaults
     */
    public static void main(String[] args) {
        SortTesterGUI window = new SortTesterGUI();   
        
    }
}
