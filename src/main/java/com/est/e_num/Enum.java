

package com.est.e_num;

/**
 * @author estevam
 */
public class Enum {

    
    @SuppressWarnings("unused")
	private static myStatus iState = myStatus.myStatus_Init;

    private static enum myStatus {

        myStatus_Init,
        myStatus_Activity,
        myStatus_Done,
        myStatus_Faild
    }
    
    
    private static void changeState(Enum.myStatus aState) {
        iState = aState;
    }

    public static void main(String[] args) {
        
        changeState(myStatus.myStatus_Done);

        // using ordinal
        if (myStatus.myStatus_Init.ordinal() == 0) {
            
        } else if (myStatus.myStatus_Activity.ordinal() == 1) {
            
        } else if (myStatus.myStatus_Done.ordinal() == 2) {
            
        }
    }
}
