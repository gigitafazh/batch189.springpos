<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	
	<!-- Font Awesome Icons -->
  	<link href="assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

 	<!-- Google Fonts -->
  	<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
  	<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>

  	<!-- Plugin CSS -->
  	<link href="assets/magnific-popup/magnific-popup.css" rel="stylesheet">

  	<!-- Theme CSS - Includes Bootstrap -->
  	<link href="assets/css/creative.min.css" rel="stylesheet">
	
	<title>Daftar Barang</title>
</head>

<body class="bg-light">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="<c:url value="/" />">Amanah Ibu</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="<c:url value="barang" />">Daftar Barang
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="order" />">Order</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Tentang</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 border border-secondary" style="margin-top: 50px; margin-left: 50px; margin-right: 50px">
            	<h3 class="mb-5 mt-5 text-center">Formulir Barang</h3>
            	<form id="form-barang" style="margin-bottom: 100px;">
                <div class="mb-3">
                    <label>Kode Barang</label>
                    <input type="text" class="form-control" id="kode" name="kode">
                </div>
                <div class="mb-3">
                    <label>Nama Barang</label>
                    <input type="text" class="form-control" id="nama" name="nama">
                </div>
                <div class="mb-3">
                    <label>Harga</label>
                    <input type="text" class="form-control" id="harga" name="harga">
                </div>
                <div class="mb-3">
                    <label>Satuan</label>
                    <input type="text" class="form-control" id="satuan" name="satuan">
                </div>
                <hr class="mb-4">
                <input class="btn btn-primary btn-lg" type="button" value="Submit" onclick="simpan()">
                <input class="btn btn-secondary btn-lg" type="button" value="Reset" onclick="clicked()"> &emsp;
                </form>
            </div>
            
            <div class="col-md-8">
            	<h3 class="mb-5 mt-5 text-center">Daftar Barang</h3>
				<div class="table-responsive">
				  <table class="table table-striped table-sm">
				    <thead>
				      <tr>
				        <th>Kode Barang</th>
				        <th>Nama Barang</th>
				        <th>Harga</th>
				        <th>Satuan</th>
				        <th>Action</th>
				      </tr>
				    </thead>
				    <tbody id="data-barang">
				    </tbody>
				  </table>
				</div>    
            </div>
        </div>
    </div>
    
    <!-- Footer -->
	<footer class="bg-light py-5">
		<div class="container">
			<div class="small text-center text-muted">Copyright &copy; 2019
				- Amanah Ibu</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="assets/jquery/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="assets/jquery-easing/jquery.easing.min.js"></script>
	<script src="assets/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="assets/js/creative.min.js"></script>
    
	<script>
		var modeSubmit = 'insert';

		function getFormData($form){
		    var unindexed_array = $form.serializeArray();
		    var indexed_array = {};
		    $.map(unindexed_array, function(n, i){
		        indexed_array[n['name']] = n['value'];
		    });
		    return indexed_array;
		}

		function clicked() {
			location = 'form-reset.html';
		}
		
		function tampilkanData(d) {
			var s = '';
			$(d).each(function(index, element) {
				s += '<tr>';
				s += '<td>' + element.kode + '</td>';
				s += '<td>' + element.nama + '</td>';
				s += '<td>' + element.harga + '</td>';
				s += '<td>' + element.satuan + '</td>';
				s += '<td>' + 
						'<input class="btn btn-secondary btn-sm" type="button" value="Edit" onclick="load(\'' + element.kode + '\')"> &nbsp;' +
						'<input class="btn btn-danger btn-sm" type="button" value="Hapus" onclick="hapus(\'' + element.kode + '\')">' +
				     '</td>';
			    s += '</tr>';
			})
            $('#data-barang').html(s);
		}

        function loadData() {
            $.ajax({
                type: 'get',
                url: 'barang/',
                success: function(d) {
                    tampilkanData(d);
                },
                error: function(d) {
					console.log('Error');
                }
            });
        }

        function simpan() {
            var method;
            var data = getFormData($('#form-barang'));
			if(modeSubmit == 'insert') {
				method = 'post';
			} else {
				method = 'put';
			}
			$.ajax({
                type: method,
                url: 'barang/',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(d) {
                    loadData();
                    modeSubmit = 'insert';
                    $('#kode, #nama, #harga, #satuan').val('');
                },
                error: function(d) {
					console.log('Error');
                }
            });
        }

        function hapus(kode) {
            $.ajax({
                type: 'delete',
                url: 'barang/' + kode,
                success: function(d) {
                    loadData();
                },
                error: function(d) {
					console.log('Error');
                }
            });
        }

        function load(kode) {
			$.ajax({
				type: 'get',
				url: 'barang/' + kode,
				success: function(d) {
					$('#kode').val(d.kode);
					$('#nama').val(d.nama);
					$('#harga').val(d.harga);
					$('#satuan').val(d.satuan);
					modeSubmit = 'update';
				},
                error: function(d) {
					console.log('Error');
                }
			});
        }

        $(document).ready(function() {
            loadData();
        });

	</script>
</body>

</html>
