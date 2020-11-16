package br.com.senior.importadorrondaseniorx.core;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class GenericException extends Exception {
	
	private static final long serialVersionUID = -2061042952678002134L;
	
	private String message;
	
    public GenericException(String message){
      super(message);
      this.message = message;
    }
    
    public String getMessage(){
      return message;
    }
    
    public void showError() {
    	Utils.showDialogMessageError("Erro", message);
    }
}
