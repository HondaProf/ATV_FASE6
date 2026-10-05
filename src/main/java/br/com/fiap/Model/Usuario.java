package br.com.fiap.Model;


import java.time.LocalDate;

public class Usuario {
    private Long codUsuario;
    private String nomeCompleto;
    private String email;
    private String senhaHash;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private Double rendaMensal;
    private String objetivo;
    private LocalDate dataCadastro;
    private String status;

    // Com código (usado ao ler do banco, no getAll)
    public Usuario(Long codUsuario, String nomeCompleto, String email, String senhaHash, String cpf,
                   String telefone, LocalDate dataNascimento, Double rendaMensal, String objetivo,
                   LocalDate dataCadastro, String status) {
        this.codUsuario = codUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.rendaMensal = rendaMensal;
        this.objetivo = objetivo;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    // Sem código (usado no insert, o banco gera o cod_usuario)
    public Usuario(String nomeCompleto, String email, String senhaHash, String cpf,
                   String telefone, LocalDate dataNascimento, Double rendaMensal, String objetivo,
                   LocalDate dataCadastro, String status) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.rendaMensal = rendaMensal;
        this.objetivo = objetivo;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    public Usuario() {
    }

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    }
