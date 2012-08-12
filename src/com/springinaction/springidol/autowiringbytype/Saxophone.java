package com.springinaction.springidol.autowiringbytype;

public class Saxophone implements Instrument {

	public Saxophone() {}
	  public void play() {
	    System.out.println("Autowired by name TOOT TOOT TOOT");
	  }

}
