                    String key = String.valueOf(pw.getText()); // si prende la pass
                    char[] pass = key.toCharArray();
                    final Key d = AES.key2(pass);
                    System.out.println("Key: " + d.getEncoded());
                    final String iv = MD5.md5(d.toString()).substring(16); // vector de inicialización
                    System.out.println("Key: " + iv);
                    final String cleartext = String.valueOf(testo.getText());// ritorna il testo manipolato


public  static Key key2(char[] password){

        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");//PBKDF2WithHmacSHA1
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
        SecretKey tmp = null;
        try {
            tmp = factory.generateSecret(spec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
    }
