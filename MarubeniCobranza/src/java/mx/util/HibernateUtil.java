/*    */ package mx.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.cfg.AnnotationConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HibernateUtil
/*    */ {
/*    */   private static final SessionFactory sessionFactory;
/*    */   
/*    */   static
/*    */   {
/*    */     try
/*    */     {
/* 25 */       sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
/*    */     }
/*    */     catch (Throwable ex) {
/* 28 */       System.err.println("Initial SessionFactory creation failed." + ex);
/* 29 */       throw new ExceptionInInitializerError(ex);
/*    */     }
/*    */   }
/*    */   
/*    */   public static SessionFactory getSessionFactory() {
/* 34 */     return sessionFactory;
/*    */   }
/*    */ }


