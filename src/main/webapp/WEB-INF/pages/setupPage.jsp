<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script>
     function deleteCurrency($currencyId) {
         if (confirm("Are you sure you want to remove the currency?" + "\n" + "ID - " + $currencyId)) {
         document.location.href = "/PurseCRUD-1.0-SNAPSHOT/delete/currency/" + $currencyId;
         } else {
              document.location.href = "/PurseCRUD-1.0-SNAPSHOT";
         }
     }
</script>