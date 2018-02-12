<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tags/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Liste des employés</h1>
            <div class="btn-group">
                <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Nouvel employé
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/employes/new/technicien">Technicien</a></li>
                    <li><a href="/employes/new/commercial">Commercial</a></li>
                    <li><a href="/employes/new/manager">Manager</a></li>
                </ul>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">
                        Matricule <a href=""><span class="glyphicon glyphicon-chevron-up"></span></a>
                    </th>
                    <th scope="col">
                        Nom <a href=""><span class="glyphicon glyphicon-chevron-down"></span></a>
                    </th>
                    <th scope="col">
                        <a href="">Prénom</a>
                    </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${model.getContent()}" var="employe">
                    <tr>
                        <th scope="row">${employe.matricule}</th>
                        <td>${employe.nom}</td>
                        <td>${employe.prenom}</td>
                        <td><a href="/employes/${employe.id}">Détail</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6">
                    <p>
                        Affichage des employés ${start} à ${end} sur un total de ${total}</p>
                </div>
                <div class="col-lg-6">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="model.getNumber.equals(0)">
                                <li class="disabled">&laquo;</li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/employes?page=${page-1}&size=${size}&sortDirection=${sortDirection}&sortProperty=${sortProperty}">&laquo;</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        </li>
                        <li><a href="#">Page ${page+1}</a></li>

                        <c:choose>
                            <c:when test="model.totalPages==pageAffichage">
                                <li class="disabled">&raquo;</li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/employes?page=${page+1}&size=${size}&sortDirection=${sortDirection}&sortProperty=${sortProperty}">&raquo;</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../tags/footer.jsp" %>
