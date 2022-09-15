package com.example.spring_boot_gpa.Contoller;

import com.example.spring_boot_gpa.Entity.Xodim;
import com.example.spring_boot_gpa.Repository.Xodim_repositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Xodim_controller {
    @Autowired
    Xodim_repositary xodim_repositary;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String Add_info(@RequestBody Xodim xodim){
    xodim_repositary.save(xodim);
    return "Malumot yozildi";
    }

    @DeleteMapping (value = "/employee/{id}")
    public  String delete5(@PathVariable("id") int id){
        xodim_repositary.deleteById(id);
        return "Delete ishladi";
    }

    @RequestMapping(value = "/Oqish",method = RequestMethod.GET)
    public List<Xodim> Oqish(){
        List<Xodim> all=xodim_repositary.findAll();
        return all;
    }

    @RequestMapping(value = "/Oqish2/{id}",method = RequestMethod.GET)
    public Xodim Oqish2(@PathVariable Integer id){
        Optional<Xodim> byId=xodim_repositary.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return new Xodim();
    }

    @RequestMapping(value = "/ochirish/{id}",method = RequestMethod.DELETE)
    public String Ochirish(@PathVariable Integer id){
        Optional<Xodim> byId=xodim_repositary.findById(id);
        if(byId.isPresent()){
            xodim_repositary.deleteById(id);
            return "Ochirildi";
        }
        return "Bunday idli malumot yoq";
    }


    @RequestMapping(value = "/taxrirlash/{id}",method = RequestMethod.PUT)
    public String Taxrirlash(@PathVariable Integer id,@RequestBody Xodim xodim){
        Optional<Xodim> byId=xodim_repositary.findById(id);
        if(byId.isPresent()){
            Xodim xodim1=byId.get();
            xodim1.setEmail(xodim.getEmail());
            xodim1.setFish(xodim.getFish());
            xodim1.setLavozim(xodim.getLavozim());
            xodim1.setMaosh(xodim.getMaosh());

            xodim_repositary.save(xodim1);
            return id+"-malumot taxrirlandi";
        }
        return "Malumot oz joyida qoldi";
    }
}
