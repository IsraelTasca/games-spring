<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <title>Editar Jogo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <h1>Editar Jogo</h1>
        <form action="/jogo/update" method="post">
            <input type="hidden" name="id" value="${jogo.id}" /> <!-- Corrigido: "${jogo.id)" para "${jogo.id}" -->
            <div class="form-group">
                <label for="titulo">Título:</label> <!-- Corrigido: "Titulo" para "Título" -->
                <input type="text" name="titulo" class="form-control" value="${jogo.titulo}" />
            </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select name="categoria" class="form-select">
                    <c:forEach var="c" items="${categorias}"> <!-- Corrigido: "$(categorias)" para "${categorias}" -->
                        <option value="${c.id}" ${jogo.categoria.id == c.id ? "selected" : ""}>${c.nome}</option> <!-- Corrigido: "${jogo,categoria.idc.id? "selected" :""}" para "${jogo.categoria.id == c.id ? "selected" : ""}" -->
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="plataforma">Plataforma(s):</label>
                <c:forEach var="p" items="${plataformas}">
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" 
                               class="custom-control-input" 
                               name="plataformas" 
                               value="${p.id}" 
                               id="${p.id}" 
                               ${jogo.plataformas.contains(p) ? "checked" : ""} /> <!-- Corrigido: "$[jogo.plataformas.contains(p)? "checked" : "" ]" para "${jogo.plataformas.contains(p) ? "checked" : ""}" -->
                        <label class="custom-control-label" for="${p.id}">${p.nome}</label> <!-- Corrigido: "${p.nome)" para "${p.nome}" -->
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
