package br.com.senior.importadorrondaseniorx.enums;

public enum ValidateRolesType {
	DISABLE("Desabilitado"),
	ENABLE("Habilitado"),
	NOT_CONFIGURED("Não configurado");
	
	private final String value;
	
    private ValidateRolesType(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
