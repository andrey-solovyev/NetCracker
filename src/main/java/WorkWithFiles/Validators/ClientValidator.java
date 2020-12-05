package WorkWithFiles.Validators;

import Exceptions.ParseException;
import People.Client;

public class ClientValidator {
    public String parse(Client client) throws ParseException {
        try {
            String[] dataPassport = client.getpassportData().split("\\s");
            if (!(client.getFcs().matches(".*\\d+.*"))){
                throw new ParseException("Invalid FCS");
            }
           if (!(dataPassport[0].matches("[-+]?\\d+") && dataPassport[0].matches("[-+]?\\d+"))) {
               throw new ParseException("Invalid passport date");
           }
            return "ok";
        } catch (ParseException e) {
            throw e;
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
