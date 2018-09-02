<jsp:include page="header.jsp"/>
<section>
    
    <div class="container">
        <div class="arr">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#dogo">Dogos</a></li>
                <li><a data-toggle="tab" href="#salchicha">Salchichas</a></li>
                <li><a data-toggle="tab" href="#pan">Panes</a></li>
            </ul>
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <p>Home</p>
                </div>
                <div id="dogo" class="tab-pane fade">
                    <p>Dogo</p>
                </div>
                <div id="salchicha" class="tab-pane fade">
                    <p>Salchicha</p>
                </div>
                <div id="pan" class="tab-pane fade">
                    <p>Pan</p>
                </div>
            </div>
        </div>
    </div>
    
    
    <button class="btn" type="button" id="ajaxBasico">Realiza una peticion</button>
    <div id="solicitud_1"></div>
    
</section>
<jsp:include page="footer.jsp"/>
