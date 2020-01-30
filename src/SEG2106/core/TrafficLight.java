package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  enum Status { northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow,
    northGreenArrow, northYellow, southGreenArrow, southYellow, westGreenArrow, westAndEastGreen }
  private Status status;
  enum TrafficMode {low, moderate, high}
  private TrafficMode mode;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager;
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
	this.trafficLightManager = trafficLightManager;

	setStatus(Status.northAndSouthGreen);

    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;

    if (mode == TrafficMode.high){
      switch (aStatus)
      {
        case northGreenArrow:
          setStatus(Status.northYellow);
          wasEventProcessed = true;
          break;
        case southGreenArrow:
          setStatus(Status.southYellow);
          wasEventProcessed = true;
          break;
        case westGreenArrow:
          setStatus(Status.westAndEastGreen);
          wasEventProcessed = true;
          break;
        case westAndEastGreen:
          setStatus(Status.westAndEastYellow);
          wasEventProcessed = true;
          break;
        default:
          setStatus(Status.northYellow);
          wasEventProcessed = true;
      }
    } else {
      switch (aStatus) {
        case northAndSouthGreen:
          setStatus(Status.northAndSouthYellow);
          wasEventProcessed = true;
          break;
        case northAndSouthRed:
          setStatus(Status.westAndEastYellow);
          wasEventProcessed = true;
          break;
        default:
          // Other states do respond to this event
      }
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    if (mode == TrafficMode.high){
        switch (aStatus) {
          case northYellow:
            setStatus(Status.southGreenArrow);
            wasEventProcessed = true;
            break;
          case southYellow:
            setStatus(Status.westGreenArrow);
            wasEventProcessed = true;
            break;
          case westAndEastYellow:
            setStatus(Status.northGreenArrow);
            wasEventProcessed = true;
            break;
          default:
            setStatus(Status.southGreenArrow);
            wasEventProcessed = true;
        }
    } else {
      switch (aStatus) {
        case northAndSouthYellow:
          setStatus(Status.northAndSouthRed);
          wasEventProcessed = true;
          break;
        case westAndEastYellow:
          setStatus(Status.northAndSouthGreen);
          wasEventProcessed = true;
          break;
        default:
          // Other states do respond to this event
      }
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    if (mode == TrafficMode.high){
      switch(status)
      {
        case northGreenArrow:
          // line 5 "model.ump"
          trafficLightManager.northGreenAndArrow();
          // line 6 "model.ump"
          trafficLightManager.southRed();
          // line 7 "model.ump"
          trafficLightManager.westRed();
          // line 8 "model.ump"
          trafficLightManager.eastRed();
          break;
        case northYellow:
          // line 12 "model.ump"
          trafficLightManager.northYellow();
          // line 13 "model.ump"
          trafficLightManager.southRed();
          // line 14 "model.ump"
          trafficLightManager.westRed();
          // line 15 "model.ump"
          trafficLightManager.eastRed();
          break;
        case southGreenArrow:
          // line 19 "model.ump"
          trafficLightManager.northRed();
          // line 20 "model.ump"
          trafficLightManager.southGreenAndArrow();
          // line 21 "model.ump"
          trafficLightManager.westRed();
          // line 22 "model.ump"
          trafficLightManager.eastRed();
          break;
        case southYellow:
          // line 26 "model.ump"
          trafficLightManager.northRed();
          // line 27 "model.ump"
          trafficLightManager.southYellow();
          // line 28 "model.ump"
          trafficLightManager.westRed();
          // line 29 "model.ump"
          trafficLightManager.eastRed();
          break;
        case westGreenArrow:
          // line 33 "model.ump"
          trafficLightManager.northRed();
          // line 34 "model.ump"
          trafficLightManager.southRed();
          // line 35 "model.ump"
          trafficLightManager.westGreenAndArrow();
          // line 36 "model.ump"
          trafficLightManager.eastRed();
          break;
        case westAndEastGreen:
          // line 40 "model.ump"
          trafficLightManager.northRed();
          // line 41 "model.ump"
          trafficLightManager.southRed();
          // line 42 "model.ump"
          trafficLightManager.westGreen();
          // line 43 "model.ump"
          trafficLightManager.eastGreen();
          break;
        case westAndEastYellow:
          // line 47 "model.ump"
          trafficLightManager.northRed();
          // line 48 "model.ump"
          trafficLightManager.southRed();
          // line 49 "model.ump"
          trafficLightManager.westYellow();
          // line 50 "model.ump"
          trafficLightManager.eastYellow();
          break;
      }
    } else {
      System.out.println("Simple");
      // entry actions and do activities
      switch(status)
      {
        case northAndSouthGreen:
          // line 8 "model.ump"
          trafficLightManager.northGreen();
          // line 9 "model.ump"
          trafficLightManager.southGreen();
          // line 10 "model.ump"
          trafficLightManager.westRed();
          // line 11 "model.ump"
          trafficLightManager.eastRed();
          break;
        case northAndSouthYellow:
          // line 16 "model.ump"
          trafficLightManager.northYellow();
          // line 17 "model.ump"
          trafficLightManager.southYellow();
          // line 18 "model.ump"
          trafficLightManager.westRed();
          // line 19 "model.ump"
          trafficLightManager.eastRed();
          break;
        case northAndSouthRed:
          // line 24 "model.ump"
          trafficLightManager.northRed();
          // line 25 "model.ump"
          trafficLightManager.southRed();
          // line 26 "model.ump"
          trafficLightManager.westGreen();
          // line 27 "model.ump"
          trafficLightManager.eastGreen();
          break;
        case westAndEastYellow:
          // line 32 "model.ump"
          trafficLightManager.northRed();
          // line 33 "model.ump"
          trafficLightManager.southRed();
          // line 34 "model.ump"
          trafficLightManager.westYellow();
          // line 35 "model.ump"
          trafficLightManager.eastYellow();
          break;
      }
    }
  }

  public void delete()
  {}

@Override
public boolean moderateTraffic() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean lowTraffic() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean highTraffic() {
  boolean wasEventProcessed = false;
  mode = TrafficMode.high;
  status = Status.northGreenArrow;
  return wasEventProcessed;
}

}