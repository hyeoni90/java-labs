package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(final String[] args) {
        final UniqueEmailAddresses uniqueEmailAddresses= new UniqueEmailAddresses();
        final String[] emails = {"test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemial+tom@cod.ing.com"};

        System.out.println(uniqueEmailAddresses.uniqueEmailsNum(emails));
    }

    private int uniqueEmailsNum(final String[] emails) {
        // 1.
        final Set<String> set = new HashSet<>();
        
        // 2.
        for (final String email : emails) {
            final String localName = makeLocalName(email);  // testemail
            final String domainName = makeDomainName(email); // @
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String makeLocalName(final String email) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i ++) {

            if(email.charAt(i) == '.') {
                continue;
            }

            if(email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }

            final String str = String.valueOf(email.charAt(i));
            sb.append(str);
        }

        return sb.toString();
    }

    private String makeDomainName(final String email) {
        return email.substring(email.indexOf('@') + 1);
    }

}
