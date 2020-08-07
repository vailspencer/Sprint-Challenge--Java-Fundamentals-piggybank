package lambdaschool.javapiggybank.controller;

import lambdaschool.javapiggybank.models.Coin;
import lambdaschool.javapiggybank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( value = "/money")
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

    // http://localhost:2019/money/{amount}

//    @PutMapping(value = "/{amount}", consumes = "applicaiton/json")
//    public ResponseEntity<?> updateBank(@Valid @RequestBody Coin coin, @PathVariable int amount) {
//        coin.setQuantiy(amount);
//        bankrepo.save(coin);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/money", consumes = {"application/json"})
//    public ResponseEntity<?> new bankValue (@Valid @RequestBody Coin coin){
//        coin.setQuantiy(0);
//        coin =
//}
}
