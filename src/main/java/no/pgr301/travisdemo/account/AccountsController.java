package no.pgr301.travisdemo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class AccountsController {

    private AccountRepository accountRepository;
    private static final Logger LOG = Logger.getLogger(AccountsController.class.getName());

    @Autowired
    public AccountsController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(path = "/ping")
    public String ping() {
        LOG.info("Ping");
        return "pong";
    }

    @RequestMapping(path = "/pong")
    public String pong() {
        LOG.info(String.format("Pong"));
        return "ping";
    }

    @RequestMapping(path = "/accounts/{ssn}")
    public List<Account> getAccounts(@PathVariable("ssn") String ssn) {
        LOG.info(String.format("Account list requested for %s", ssn));
        return accountRepository.findBySocialSecurityNumber(ssn);
    }
}