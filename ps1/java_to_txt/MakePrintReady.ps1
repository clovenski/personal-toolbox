# makes a ready-to-print .txt file for every .java file in the directory given as first argument
# used for Numerical Methods homework
# run once and only once, otherwise .txt files become unformatted

$dir = $args[0]
if($dir -ne $null) {
    $dir_path = ".\" + $dir
    if(Test-Path $dir_path) {
        Set-Location $dir
        $files = Get-ChildItem ".\" -filter "*.java"
        foreach ($java_file in $files) {
            $txt_file = $java_file.BaseName + ".txt"
            copy-item $java_file -destination $txt_file
            add-content $txt_file "`r`n`r`nOUTPUT"
            java $java_file.BaseName | out-file $txt_file -append -encoding ascii
        }
        Set-Location ..
    }
}
