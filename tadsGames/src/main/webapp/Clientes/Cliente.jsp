<%-- 
    Document   : Cliente
    Created on : 10/10/2019, 20:04:59
    Author     : henrique.abastos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            .erro-input {
                display: none;
                color: #e74c3c;
            }
            .com-erro {
                display: block;
            }
            input[type='text'],
            input[type='email'],
            input[type='number'],
            input[type='password'],
            input[type='date'],
            textarea {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <main>
            <div>
                <section style="width: 70%; margin: 0 auto">
                    <h1>Formulário</h1>
                    <form method="post" action="">
 
                        <input type="hidden" name="id" value="123">

                        <div>
                            <label for="txtNome">
                                Nome
                            </label>
                            <div>
                                <input type="text" name="nome" id="txtNome" 
                                       placeholder="Nome" 
                                       required maxlength="100" />
                                <div class="erro-input">
                                    Digite um nome.
                                </div>
                            </div>
                        </div>

                        <div>
                            <label for="txtDescricao">
                                Descrição
                            </label>
                            <div>
                                <textarea name="descricao" id="txtDescricao" placeholder="Descrição">
                                </textarea>
                            </div>
                        </div>

                        <div>
                            <label for="txtEmail">
                                E-mail
                            </label>
                            <div>
                                <input type="email" name="email" id="txtEmail" 
                                       placeholder="E-mail"
                                       required />
                                <div class="erro-input">
                                    Digite um e-mail.
                                </div>
                            </div>
                        </div>
                        <div>
                            <label for="txtSenha">
                                Senha
                            </label>
                            <div>
                                <input type="password" name="senha" id="txtSenha" 
                                       placeholder="Senha">
                            </div>
                        </div>
                        <div>
                            <label for="txtRepetirSenha">
                                Repetir senha
                            </label>
                            <div>
                                <input type="password" name="repetirSenha" id="txtRepetirSenha" 
                                      placeholder="Repetir senha">
                            </div>
                        </div>

                        <div>
                            <label for="txtNumero">
                                Número da sorte
                            </label>
                            <div>
                                <input type="number" name="numeroSorte" id="txtNumero" 
                                       placeholder="Número de 1 a 99" 
                                       min="1" max="99" >
                                <div class="erro-input">
                                    Digite um número válido.
                                </div>
                            </div>
                        </div>

                        <div>
                            <label for="txtAltura">
                                Altura
                            </label>
                            <div>
                                <input type="number" name="altura" id="txtAltura" 
                                       placeholder="Altura em metros com no máximo 2 casa decimais" 
                                       min="0" max="9.99" step="0.01">
                                <div class="erro-input">
                                    Digite uma altura válida.
                                </div>
                            </div>
                        </div>

                        <div>
                            <label for="txtPeso">
                                Peso
                            </label>
                            <div>
                                <input type="number" name="peso" id="txtPeso" 
                                       placeholder="Peso em Kg com no máximo 1 casa decimal" 
                                       min="0" max="999.9" step="0.1">
                                <div class="erro-input">
                                    Digite um peso válido.
                                </div>
                            </div>
                        </div>

                        <div>
                            <label for="txtDtNascimento">
                                Data de nascimento
                            </label>
                            <div>
                                <input type="date" name="dtNascimento" id="txtDtNascimento" />
                                <div class="erro-input">
                                    Digite uma data válida.
                                </div>
                            </div>
                        </div>

                        <fieldset>
                            <legend>Sexo</legend>
                            <div>
                                <div>
                                    <input type="radio" name="sexo" 
                                           id="optSexoF" value="0" checked />
                                    <label for="optSexoF">
                                        Feminino
                                    </label>
                                </div>
                                <div>
                                    <input type="radio" name="sexo"
                                           id="optSexoM" value="1" />
                                    <label for="optSexoM">
                                        Masculino
                                    </label>
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <legend>Interesses</legend>
                            <div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesTecnologia" value="Tecnologia" />
                                    <label for="interessesTecnologia">
                                        Tecnologia
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesGastronomia" value="Gastronomia" />
                                    <label for="interessesGastronomia">
                                        Gastronomia
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesViagens" value="Viagens" />
                                    <label for="interessesViagens">
                                        Viagens
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesInvestimentos" value="Investimentos" />
                                    <label for="interessesInvestimentos">
                                        Investimentos
                                    </label>
                                </div>
                                <div class="erro-input">Selecione pelo menos uma opção</div>
                            </div>
                        </fieldset>
                        <div>
                            <button type="submit">Enviar</button>
                            <button type="reset">Resetar dados</button>
                            <a href="#" role="button">Cancelar</a>
                        </div>
                    </form>
                </section>
            </div>
        </main>

    </body>
</html>
