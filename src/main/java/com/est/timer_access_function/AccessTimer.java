
package com.est.timer_access_function;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author estevam
 */
public class AccessTimer {

    private final int REFRESH_TIME = 60 * 1000;
    private Calendar iHomeDateTime;
    private static List<AnimalBeen> iAnimalList;

    /**
     *  Essa funcao permite o accesso de uma nova lista entre 60 e 60 segundos
     *  se n, retornar a antiga lista
     * 
     *  ---> Nao esquecer de cancelar o timer
     * 
     * @param args 
     */
    
    
    public static void main(String[] args) {

        AccessTimer timer = new AccessTimer();
        List<AnimalBeen> animalList = timer.getAnimalList();

        System.out.println("+++++++++++++");
        for (AnimalBeen a : animalList) {
            System.out.println("Animal List->" + a.getId() + " " + a.getName());
        }

    }
            
            
    public List<AnimalBeen> getAnimalList() {
        loadData();
        if (iAnimalList != null && iHomeDateTime != null) {
            //Calendar nowtime = Calendar.getInstance();
            Calendar diffTime = Calendar.getInstance();
            int sec = (int) iHomeDateTime.getTimeInMillis();
            diffTime.add(Calendar.MILLISECOND, -sec);

            if (diffTime.getTimeInMillis() <= REFRESH_TIME) {
                return iAnimalList;
            }
        }

        return iAnimalList;
    }

	public void loadData() {
        AnimalBeen animal01 = new AnimalBeen();
        animal01.setId(0);
        animal01.setName("boi");
        animal01.setSpecie("boi");
        AnimalBeen animal02 = new AnimalBeen();
        animal02.setId(1);
        animal02.setName("cavalo");
        animal02.setSpecie("cavalo");
        AnimalBeen animal03 = new AnimalBeen();
        animal03.setId(2);
        animal03.setName("leao");
        animal03.setSpecie("leao");
        iAnimalList = new ArrayList<AnimalBeen>();
        iAnimalList.add(animal01);
        iAnimalList.add(animal02);
        iAnimalList.add(animal03);
    }
    
    

    
/**  DateTime
     
private static final long REFRESH_TIME = 60 * 1000;
private DateTime iHomeDateTime;
private List<Status> iHomeList;

// ---> Nao esquecer de cancelar o timer


 public List<Status> listTweets(Twitter aTwitter, int aRequestPage, int aRequestElements) {

        if (iHomeList != null && iHomeDateTime != null) {
            DateTime nowtime = DateTime.now();
            DateTime diffTime = nowtime.minus(iHomeDateTime.getMillis());
            
            if (diffTime.getMillis() <= REFRESH_TIME) {
                return iHomeList;
            } 
        }
         
       return iHomeList;
        
    }
     * 
     */
    
    
    
    /**
     * 
     * 
     *  correto:
     * 
     * 	public ArrayList<MazeEntity> checkMazeListStatus() {
		// loadData();
		if (iMazeList != null && iHomeDateTime != null) {
		    Calendar nowtime = Calendar.getInstance();
			int secNow = (int) nowtime.getTimeInMillis();
			int sec =  (int) iHomeDateTime.getTimeInMillis();
			int diff = secNow - sec;
			
		//	iHomeDateTime.add(Calendar.MILLISECOND, -sec);
			System.out.print(diff +" : "+ REFRESH_TIME);
			
			if (diff <= REFRESH_TIME) {
				System.out.print("waiting for the timer !");
				return iMazeList;
			} else {
				System.out.print("After 30 sec new maze!");
				iMazeList = new ArrayList<MazeEntity>();
			    iHomeDateTime = Calendar.getInstance();
			    
			}
		}
     */
}
