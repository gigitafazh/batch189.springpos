<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- Font Awesome Icons -->
  	<link href="assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

 	<!-- Google Fonts -->
  	<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
  	<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>

  	<!-- Plugin CSS -->
  	<link href="assets/magnific-popup/magnific-popup.css" rel="stylesheet">

  	<!-- Theme CSS - Includes Bootstrap -->
  	<link href="assets/css/creative.min.css" rel="stylesheet">
	
	<title>Order</title>
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
					<li class="nav-item"><a class="nav-link" href="<c:url value="barang" />">Daftar Barang</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="order" />">Order
							<span class="sr-only">(current)</span>
					</a></li>
					
					<li class="nav-item"><a class="nav-link" href="#">Tentang</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h3 class="mb-5 mt-5">Formulir Order</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <form id="form-order">
                <div class="mb-3">
                    <label>Kode Transaksi</label>
                    <input type="text" class="form-control" id="kode" name="kode">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label>Nama Pelanggan</label>
                    <input type="text" class="form-control" id="namaPelanggan" name="namaPelanggan">
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label>Tanggal Transaksi</label>
                    <input type="date" class="form-control" id="tglTransaksi" name="tglTransaksi">
                </div>
            </div>
            <hr class="mb-4">
        </div>

        <div class="row">
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Barang</label>
                    <select class="custom-select d-block w-100" id="barang" name="barang">
                    </select>
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label>Jumlah Barang</label>
                    <input type="number" class="form-control" id="jumlahBarang" name="jumlahBarang" value="1">
                </div>
            </div>
            <div class="col-md-2">
                <div class="mb-3">
                    <label>&nbsp;</label><br>
                    <input class="btn btn-primary" type="button" value="Tambah" onclick="tambahOrderDetail()">
                </div>
            </div>
            <hr class="mb-4">
        </div>

        <div class="row">
            <div class="col-md-12">
            	<h3 class="mb-5 mt-5 text-center">Order Detail</h3>
				<div class="table-responsive">
				  <table class="table table-striped table-sm">
				    <thead>
				      <tr>
				        <th>Kode Barang</th>
				        <th>Nama Barang</th>
				        <th>Harga Satuan</th>
				        <th>Jumlah Barang</th>
				        <th>Subtotal (Rp)</th>
				      </tr>
				    </thead>
				    <tbody id="data-order-detail">
				    </tbody>
				  </table>
				</div>    
            </div>
        </div>

        <div class="row">
            <div class="col-md-8">
                <label>&nbsp;</label><br>
                <input class="btn btn-primary" type="button" value="Submit" onclick="simpanOrder()">
            </div>
            <div class="col-md-4">
                <label>Grand Total (Rp)</label>
                <input type="text" class="form-control" id="grandTotal" name="grandTotal" readonly>
            </div>
            </form>
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

        // fungsi utk membuat detailOrder yg akan disubmit 
        var orderDetails = [];

        function tambahOrderDetail() {
            var elementBaru = true;

            $.each(orderDetails, function(index, element) {
                if (element.id.kodeBarang == $('#barang').val()) {
                    element.jumlahBarang = Number(element.jumlahBarang) + Number($('#jumlahBarang').val());
                    elementBaru = false;
                }
            });

            if (elementBaru) {
                var orderDetail = {};
                orderDetail.id  = {};
                orderDetail.id.kodeOrder  = '';
                orderDetail.id.kodeBarang = $('#barang').val();
                orderDetail.hargaSatuan   = $('#barang > option:selected').data('harga');
                orderDetail.jumlahBarang  = $('#jumlahBarang').val();
                orderDetail.h_namaBarang  = $('#barang > option:selected').data('nama');
                // tanpa subtotal
                
                orderDetails.push(orderDetail);
            }

            refreshDaftarBarang();
        }

        // fungsi utk input detailOrder ke object order & kirim data order
        var order = {};

        function simpanOrder() {
            $.each(orderDetails, function(index, element){
                element.id.kodeOrder  = $('#kode').val();
            });

			order.kode = $('#kode').val();
			order.namaPelanggan = $('#namaPelanggan').val();
			order.tglTransaksi = $('#tglTransaksi').val();
            order.orderDetails = orderDetails;

            // tanpa grandtotal
			$.ajax({
                type: 'POST',
                url: 'order/',
                data: JSON.stringify(order),
                contentType: 'application/json',
                success: function(d) {
                    order = {};
                    orderDetails = [];
                    refreshDaftarBarang();
                    $('#kode, #namaPelanggan, #tglTransaksi').val('');
                    $('#jumlahBarang').val('1');
                },
                error: function(d) {
					console.log('Error - simpan');
                }
            });
        }

        // fungsi utk refresh daftar barang dan nilai grand total
        function refreshDaftarBarang() {
            var subTotal = 0;
            var grandTotal = 0;
            var s = '<tr>';

            $.each(orderDetails, function(index, element) {
                subTotal = element.hargaSatuan * element.jumlahBarang;
                s += '<td>' + element.id.kodeBarang + '</td>';
                s += '<td>' + element.h_namaBarang + '</td>';
                s += '<td>' + element.hargaSatuan + '</td>';
                s += '<td>' + element.jumlahBarang + '</td>';
                s += '<td>Rp' + subTotal + '</td>';
                s += '</tr>';
                grandTotal += subTotal;
            });

            $('#data-order-detail').html(s);
            $('#grandTotal').val(grandTotal);
        }	

        // fungsi awal utk load data dropdown
        function loadData() {
            $.ajax({
                type: 'GET',
                url: 'barang/',
                success: function(d) {
                    tampilkanData(d);
                },
                error: function(d) {
					console.log('Error - loadData');
                }
            });
        }

        function tampilkanData(d) {
			var s = '<option>Silahkan Pilih</option>';
			$(d).each(function(index, element) {
                s += '<option value="' + element.kode 
                    + '" data-nama="' + element.nama
                    + '" data-harga="' + element.harga + '">' 
                    + element.kode + ' - ' 
                    + element.nama + ' - Rp' 
                    + element.harga 
                    + '</option>';
			});
            $('#barang').html(s);
        }

        // document.ready
        $(document).ready(function() {
            loadData();
        });

	</script>
</body>

</html>
