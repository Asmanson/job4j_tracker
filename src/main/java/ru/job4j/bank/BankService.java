package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует систему банковских переводов, с помощью которой можно:
 * Регистрировать пользователя
 * Удалять пользователя из системы
 * Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов
 * Переводить деньги с одного банковского счета на другой счет
 * @author Asmanov Ivan
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в моделе типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить пользователя в систему
     * @param user парметр пользователя к которому добавляется пустой список new ArrayList<Account>()
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя из системы
     * @param passport паспорт пользователя, по которому происходит удаление
     * @return Возращает true, если пользователь был удален
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, null)) != null;
    }

    /**
     * Метод добавляет новый счет к пользователю
     * Новый счет добалвется только если пользователь существует в системе
     * и если такого счет не пристутствует у пользователя уже
     * @param passport паспорт пользователя, по которому происходит поиск пользователя
     * @param account счет пользователя, который добавлется к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользлвателя по паспорту
     * производя поиск по перебору всех элементов
     * @param passport паспорт пользователя, по которому происходит поиск пользователя
     * @return если пользователь не был найдет, возвращет null, в ином случае возвразает пользователя
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод призводит поиск счета пользователя по реквизитам,
     * производя поиск по паспорту, в следствии находя счет
     * @param passport паспорт пользователя, по которому происходит поиск пользователя
     * @param requisite реквизит счета, по которому происходит поиск счета
     * @return возвращает null, если счет был не найдет, или возвращает найденый счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account req : accounts) {
                if (req.getRequisite().equals(requisite)) {
                    rsl = req;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, с счета которого происходит первод средств
     * @param srcRequisite реквизит счета, с которого происходит первод средств
     * @param destPassport паспорт пользователя, на счет которого происходит первод средств
     * @param destRequisite реквизит счета, на который происходит первод средств
     * @param amount количество средств списания и зачисления
     * @return возвращет true, если перевод средств произошел успешно; false, если счет или пользователь
     * не были найдены или количество средств списания превышает средства на счете списания
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && (srcAccount.getBalance() - amount) >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возращает данные по пользователю
     * @param user парметр пользователя
     * @return возращает данные по пользователю
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}