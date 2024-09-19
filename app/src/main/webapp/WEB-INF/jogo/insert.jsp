<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <title>Novo Jogo</title> <!-- Corrigido: "tiovo Jogo" para "Novo Jogo" -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <h1>Novo Jogo</h1>
        <form action="/jogo/insert" method="post">
            <div class="form-group">
                <label for="titulo">Título:</label> <!-- Corrigido: "Titulo" para "Título" -->
                <input type="text" name="titulo" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select name="categoria" class="form-select" required> <!-- Corrigido: "categoría" para "categoria" -->
                    <c:forEach var="c" items="${categorias}"> <!-- Corrigido: "$(categorías)" para "${categorias}" -->
                        <option value="${c.id}">${c.nome}</option> <!-- Corrigido: "${c.id)}" para "${c.id}" -->
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Plataforma(s): </label>
                <c:forEach var="p" items="${plataformas}"> <!-- Corrigido: "${plataformas}" -->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" name="plataformas" value="${p.id}" id="${p.id}" /> <!-- Corrigido: "$(p.id)" e "$[p.id}" para "${p.id}" -->
                        <label class="custom-control-label" for="${p.id}">${p.nome}</label> <!-- Corrigido: "$(p.nome)" para "${p.nome}" -->
                    </div>
                </c:forEach>
            </div>
            <br />
            <a href="/jogo/list" class="btn btn-primary">Voltar</a>
            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>
</body>
</html>
