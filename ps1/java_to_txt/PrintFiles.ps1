# prints .txt files in directory given as first argument
# meant to use after making the .java files print-ready by running MakePrintReady.ps1
# run this script if and only if programs are done and final, ie. do not waste paper

$dir = $args[0]
if($dir -ne $null) {
    $dir_path = ".\" + $dir
    if(Test-Path $dir_path) {
        Set-Location $dir
        $files = Get-ChildItem ".\" -filter "*.txt"
        foreach ($txt_file in $files) {
            Get-Content $txt_file | Out-Printer <# -Name <enter printer name here> #>
        }
        Set-Location ..
    }
}