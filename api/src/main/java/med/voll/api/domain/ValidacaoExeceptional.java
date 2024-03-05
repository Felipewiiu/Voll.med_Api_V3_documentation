package med.voll.api.domain;

public class ValidacaoExeceptional extends RuntimeException {
    public ValidacaoExeceptional(String mensagem) {
        super(mensagem);
    }
}
