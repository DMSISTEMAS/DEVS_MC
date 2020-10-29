/*    */ package mx.filtro;
/*    */ 
/*    */ import javax.faces.application.NavigationHandler;
/*    */ import javax.faces.component.UIViewRoot;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.event.PhaseEvent;
/*    */ import javax.faces.event.PhaseId;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class filtroUrl implements javax.faces.event.PhaseListener
/*    */ {
/*    */   public void afterPhase(PhaseEvent event)
/*    */   {
/* 14 */     FacesContext facesContext = event.getFacesContext();
/* 15 */     String currrentPage = facesContext.getViewRoot().getViewId();
/* 16 */     boolean isPageLogin = currrentPage.lastIndexOf("/index.xhtml") > -1;
/* 17 */     HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
/* 18 */     Object nombre = session.getAttribute("nombre");
/* 19 */     if ((!isPageLogin) && (nombre == null)) {
/* 20 */       NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
/* 21 */       nHandler.handleNavigation(facesContext, null, "/index.xhtml");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void beforePhase(PhaseEvent event) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public PhaseId getPhaseId()
/*    */   {
/* 34 */     return PhaseId.RESTORE_VIEW;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\filtro\filtroUrl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */