package paking;

import java.util.List;

abstract class ParkingAb {

    /**
     * field object for transfer of the logic work our parking
     */
    private ILogicWork iLogicWork;


    protected ParkingAb(ILogicWork iLogicWork) {
        this.iLogicWork = iLogicWork;
    }

    /**
     * procedure for make work of our parking.
     */
    abstract void work(Car car);

    public ILogicWork getiLogicWork() {
        return iLogicWork;
    }


}
