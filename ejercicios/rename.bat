@echo off
setlocal enabledelayedexpansion

echo.
echo === INICIANDO RENOMBRE NUMERICO DE ARCHIVOS .java ===
echo.

:: Iterar sobre los archivos que comienzan con 'e' y terminan en '.java'
for %%f in (e*.java) do (
    call :RENAME_FILE "%%f"
)

echo.
echo === PROCESO COMPLETADO ===
echo.

endlocal
pause
goto :EOF

:: Subrutina para renombrar un archivo
:RENAME_FILE
    :: Recibir el nombre completo del archivo como argumento
    set "full_name=%~1"
    
    :: Obtener el nombre sin la extension (ej: "e5")
    set "filename_no_ext=%~n1"
    
    :: Extraer solo el número (ej: de "e5" toma "5")
    set "number_str=!filename_no_ext:~1!"
    
    :: Asegurarse de que el resto del nombre es un número (o al menos no está vacío)
    if defined number_str (
        
        :: Realizar la resta: N = N - 1
        set /a "new_number=!number_str! - 1"
        
        :: Construir el nuevo nombre: "e" + (N-1) + ".java"
        set "newname=e!new_number!.java"
        
        :: Renombrar el archivo
        ren "!full_name!" "!newname!"
        
        echo Archivo renombrado: "!full_name!" --^> "!newname!"
    ) else (
        echo Archivo ignorado: "!full_name!" (No sigue el patron eN.java)
    )
goto :EOF