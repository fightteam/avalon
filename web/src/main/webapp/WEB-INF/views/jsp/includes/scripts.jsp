<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="${scripts.jquery}"></script>
<script type="text/javascript" src="${scripts.bootstrap}"></script>
<script type="text/javascript" src="${scripts['jquery-nicescroll']}"></script>
<script type="text/javascript" src="/assets/components/datatables/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="/assets/components/datatables/plugins/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $("html").niceScroll();
        $("#table").dataTable();
    });
</script>
