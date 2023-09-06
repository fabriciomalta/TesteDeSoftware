import whisper
import time
inicio = time.time()
print("Carregando modelo...");
model = whisper.load_model("base")
print("Sucesso!, Transcrevendo áudio, aguarde...")
result = model.transcribe("ep2_v.wav", )
# print(result["text"])
with open("ep1_teste.txt", "w") as arquivo:
    arquivo.write(result['text'])
    
tempo_decorrido = time.time() - inicio
print(f"Tempo decorrido: {tempo_decorrido} segundos")
