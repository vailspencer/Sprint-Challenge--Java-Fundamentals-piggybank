package lambdaschool.javapiggybank.controller;

import lambdaschool.javapiggybank.models.Coin;
import lambdaschool.javapiggybank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PiggyBankController
{
    @Autowired
    PiggyBankRepository bankrepo;

    // http://localhost:2019/total
    @GetMapping(value = "total", produces = "applicaiton/json")
    public ResponseEntity<?> bankTotal() {
        double bankContents = 0;
        List<Coin> bankList = new ArrayList<>();
        List<String> rtnList = new ArrayList<>();

        bankrepo.findAll().iterator().forEachRemaining(bankList::add);
        for(Coin c: bankList) {
            bankContents += c.getValue() * c.getQuantiy();
            rtnList.add(c.getTotal());
        }
        for(String c : rtnList){
            System.out.println(c);
        }
        System.out.println("The Piggy bank holds $ " + bankContents);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
