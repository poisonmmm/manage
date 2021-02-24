package com.example.supermarket_kdxfproject2.servers;
import com.example.supermarket_kdxfproject2.common.ResultBean;
import com.example.supermarket_kdxfproject2.dao.CargoDao;
import com.example.supermarket_kdxfproject2.dao.LogsDao;
import com.example.supermarket_kdxfproject2.entity.Cargo;
import com.example.supermarket_kdxfproject2.entity.Logs;

import java.util.ArrayList;
import java.util.Objects;

public class cargoServers {
    //入库
    public static ResultBean Entrant(Cargo cargo){
        ResultBean resultBean = new ResultBean();
        CargoDao cargoDao = new CargoDao();
        Cargo getCargo = cargoDao.selectCargo(cargo);
        if (Objects.equals(getCargo.getName(), cargo.getName()))
        {
            getCargo.setNumber(cargo.getNumber()+getCargo.getNumber());
            cargoDao.updateNumber(getCargo);
            resultBean.setCode("1");
            resultBean.setMsg("添加库存成功");
            LogsDao.insertLogs(new Logs(cargo.getName(),cargo.getNumber()));
            return resultBean;
        }
        cargoDao.EntrantCargo(cargo);
        LogsDao.insertLogs(new Logs(cargo.getName(),cargo.getNumber()));
        resultBean.setCode("1");
        resultBean.setMsg("添加成功");
        return resultBean;
    }

    //出库
    public static ResultBean delivery(Cargo cargo){
        ResultBean resultBean = new ResultBean();
        CargoDao cargoDao = new CargoDao();
        Cargo getCargo = cargoDao.selectCargo(cargo);
        if (Objects.equals(getCargo.getName(), cargo.getName())){
            if (getCargo.getNumber()<cargo.getNumber()){
                resultBean.setCode("0");
                resultBean.setMsg("库存不足");
                return resultBean;
            }
            getCargo.setNumber(getCargo.getNumber()-cargo.getNumber());
            cargoDao.updateNumber(getCargo);
            resultBean.setCode("1");
            resultBean.setMsg("删除库存数量成功");
            LogsDao.insertLogs(new Logs(cargo.getName(),-cargo.getNumber()));
            return resultBean;
        }
        resultBean.setCode("0");
        resultBean.setMsg("库存不存在，删除失败");
        return resultBean;
    }

    //添加库存数量
//    public static ResultBean addCargoNumber(Cargo cargo){
//        ResultBean resultBean = new ResultBean();
//        CargoDao cargoDao = new CargoDao();
//        Cargo getCargo = cargoDao.selectCargo(cargo);
//        if (Objects.equals(getCargo.getName(),cargo.getName())){
//            getCargo.setNumber(cargo.getNumber()+getCargo.getNumber());
//            cargoDao.updateNumber(getCargo);
//            resultBean.setCode("1");
//            resultBean.setMsg("添加库存数量成功");
//            return resultBean;
//        }
//        resultBean.setCode("0");
//        resultBean.setMsg("添加库存失败");
//        return resultBean;
//
//    }

//    //减少库存数量
//    public static ResultBean reduceCargoNumber(Cargo cargo){
//        ResultBean resultBean = new ResultBean();
//        CargoDao cargoDao = new CargoDao();
//        Cargo getCargo = cargoDao.selectCargo(cargo);
//        if (Objects.equals(getCargo.getName(),cargo.getName())){
//            if (getCargo.getNumber()<cargo.getNumber()){
//                resultBean.setCode("0");
//                resultBean.setMsg("库存不足");
//                return resultBean;
//            }
//            getCargo.setNumber(getCargo.getNumber()-cargo.getNumber());
//            cargoDao.updateNumber(getCargo);
//            resultBean.setCode("1");
//            resultBean.setMsg("删除库存数量成功");
//            return resultBean;
//        }
//        resultBean.setCode("0");
//        resultBean.setMsg("添加库存失败");
//        return resultBean;
//    }


    //查看所有货物
    public static ArrayList<Cargo> showAllCargo(){
        CargoDao cargoDao = new CargoDao();
        return cargoDao.selectAllCargo();
    }


}
