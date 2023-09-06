# import subprocess
# import time

# # Comando que você deseja executar
# comando = "stt --model model.tflite --audio converted_files/ep1.wav"

# # Inicia o cronômetro
# inicio = time.time()

# # Use o subprocess para executar o comando
# try:
#     resultado = subprocess.run(comando, shell=True, text=True, capture_output=True, check=True)
#     # Salve a saída do comando em um arquivo de texto
#     with open("resultado.txt", "w") as arquivo:
#         arquivo.write(resultado.stdout)
#     # Imprima a saída do comando
#     print(resultado.stdout)
# except subprocess.CalledProcessError as e:
#     # Se ocorrer um erro, você pode lidar com ele aqui
#     print("O comando falhou. Código de saída:", e.returncode)
#     print("Saída de erro:", e.stderr)

# # Calcula o tempo decorrido
# tempo_decorrido = time.time() - inicio
# print(f"Tempo decorrido: {tempo_decorrido} segundos")


import subprocess
import time
import psutil

# Comando que você deseja executar
comando = "stt --model model.tflite --audio ep1_v.wav"
#comando = "stt --model model.tflite --audio converted_files/ep1.wav"

# Inicia o cronômetro
inicio = time.time()

# Use o subprocess para executar o comando
try:
    # Executa o comando em background
    processo = subprocess.Popen(comando, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    # Define a prioridade em tempo real (nível 1)
    psutil.Process(processo.pid).nice(psutil.HIGH_PRIORITY_CLASS)
    
    # Aguarde o término do processo
    stdout, stderr = processo.communicate()

    # Salve a saída do comando em um arquivo de texto
    with open("resultado.txt", "w") as arquivo:
        arquivo.write(stdout.decode())
    
    # Imprima a saída do comando
    #print(stdout.decode())
except subprocess.CalledProcessError as e:
    # Se ocorrer um erro, você pode lidar com ele aqui
    print("O comando falhou. Código de saída:", e.returncode)
    print("Saída de erro:", e.stderr.decode())

# Calcula o tempo decorrido
tempo_decorrido = time.time() - inicio
print(f"Tempo decorrido: {tempo_decorrido} segundos")
