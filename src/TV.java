public class TV   //class
	{
		int channel = 1;  //data field
		int volume = 1;
		boolean on = false;
 
	public TV()  //no argument constructors
	{
	}
	
	public void turnOn() //constructor with argument
	{
		on = true;
	}
	
	public void turnOff() //constructor with argument
	{
		on = false;
	}
	
	public void setChannel(int newChannel) //method
	{
		if(on && newChannel>=1 && newChannel<=120)
			channel = newChannel;
	}
	
	public void setVolume(int newVolume) //method
	{
		if(on && newVolume>=1 && newVolume<=7)
			volume = newVolume;
	}
	
	public void channelUp() //method
	{
		if(on && channel<120)
			channel++;
	}
	
	public void channelDown() //method
	{
		if(on && channel>1)
			channel--;
	}
	
	public void volumeUp() //method
	{
		if(on && volume<7)
			volume++;
	}

	public void volumeDown() //method
	{
		if(on && volume>1)
			volume--;
	}
	
	class TestTV{
		public static void main(String[] args){
		//create TV with reference variable tv1
			TV tv1 = new TV();
		//turn on TV
			tv1.turnOn();
		//set new channel
			tv1.setChannel(2);
		//set new volume
			tv1.setVolume(15);
		//create TV with reference variable tv2
			TV tv2 = new TV();
		//turn on TV
			tv2.turnOn();
		//increase channel
			tv2.channelUp();
		//increase volume
			tv2.volumeUp();
		//Display the channel and volume for tv1
			System.out.println(tv1.channel);
			System.out.println(tv1.volume);
		//Display the channel and volume for tv2
			System.out.println(tv2.channel);
			System.out.println(tv2.volume);
		}
		}
}




