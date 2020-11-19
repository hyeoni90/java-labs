package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses= new UniqueEmailAddresses();
        String[] emails = {"test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemial+tom@cod.ing.com"};

        System.out.println(uniqueEmailAddresses.uniqueEmailsNum(emails));
    }

    private int uniqueEmailsNum(String[] emails) {
        // 1.
        Set<String> set = new HashSet<>();
        
        // 2.
        for (String email : emails) {
            String localName = makeLocalName(email);  // testemail
            String domainName = makeDomainName(email); // @
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i ++) {

            if(email.charAt(i) == '.') {
                continue;
            }

            if(email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }

            String str = String.valueOf(email.charAt(i));
            sb.append(str);
        }

        return sb.toString();
    }

    private String makeDomainName(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

}
