package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String regisBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        System.out.println(bankAccount);
        bankAccountService.openAccount(bankAccount);
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
    }

    @GetMapping("/edit/{id}")
    public String getEditBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-edit";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawAccount(@PathVariable int id, @ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.withdrawBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/deposit/{id}")
    public String depositAccount(@PathVariable int id, @ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.depositBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        bankAccountService.deleteBankAccount(id);
        return "redirect:/bankaccount";
    }
}
