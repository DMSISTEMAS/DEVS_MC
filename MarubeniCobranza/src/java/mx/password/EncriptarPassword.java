/*    */ package mx.password;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class EncriptarPassword
/*    */ {
/*    */   public static String sha512(String cadena)
/*    */   {
/*  9 */     StringBuilder sb = new StringBuilder();
/*    */     try {
/* 11 */       MessageDigest md = MessageDigest.getInstance("SHA-512");
/* 12 */       md.update(cadena.getBytes());
/* 13 */       byte[] mb = md.digest();
/* 14 */       for (int i = 0; i < mb.length; i++) {
/* 15 */         sb.append(Integer.toString((mb[i] & 0xFF) + 256, 16).substring(1));
/*    */       }
/*    */     }
/*    */     catch (java.security.NoSuchAlgorithmException localNoSuchAlgorithmException) {}
/*    */     
/* 20 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\password\EncriptarPassword.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */