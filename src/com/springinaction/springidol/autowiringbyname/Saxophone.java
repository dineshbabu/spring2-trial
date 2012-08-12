package com.springinaction.springidol.autowiringbyname;

public class Saxophone implements Instrument {

	public Saxophone() {}
	  public void play() {
	    System.out.println("Autowired by type TOOT TOOT TOOT");
	  }

}
