    
<!-- Modal -->
<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalLabel">Agregar Dogo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="modal-body-dogo">
                <div class="select">
                    <select class="form-control" id="Select-Salchichas">
                        <option value="0" selected>---Seleccione una salchicha---</option>
                    </select>
                </div> 
                <div class="select">
                    <select class="form-control" id="Select-Panes">
                        <option value="0" selected>---Seleccione un Pan---</option>
                    </select>
                </div>
                <div>
                    <label class="select" for="precio-neto">Precio Neto $</label>
                    <input id="precio-neto" value="0" type="text" disabled="true">
                </div>
                <div>
                    <label class="select" for="precio-mas">Ganancia $</label>
                    <input id="precio-mas" value="0" type="text">
                </div>
                <div>
                    <label class="select" for="total-dogo">Total $</label>
                    <input id="total-dogo" type="text" disabled="true" value="0">
                </div>
            </div>
            <div class="modal-footer">
                <div id="Warning" class="alert alert-warning hidden warning" role="alert">
                </div>
                <image id="loading" class="hidden" src="img/giphy.gif">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save-changes-dogo">Save changes</button>
            </div>
        </div>
    </div>
</div>    
<!-- Modal1 -->
<div class="modal fade" id="Modal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalLabel">Agregar Dogo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>  
<!-- Modal2 -->
<div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                hola
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>   
<script src="js/main.js"></script>
</body>
</html>
