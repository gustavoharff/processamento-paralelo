Long nEps = 4

println("Quantos fatoriais você quer?")
Scanner scanner = new Scanner(System.in)
int tam = scanner.nextInt()

println("Digite ${tam} números inteiros:")
int[] vetor = new int[tam]

for (int i = 0; i < tam; i++) {
    println("Digite vetor[${i}]:")
    vetor[i] = scanner.nextInt()
}

List<Thread> threads = new ArrayList<Thread>()

for (int i = 0; i < nEps; i++) {
    final int currentThread = i

    Runnable runnable = new Runnable() {
        void run() {
            for (int y = currentThread; y < vetor.size(); y += nEps) {
                BigDecimal fat = 1

                for (int j = 2; j <= vetor[y]; j++) {
                    fat = (fat * j).toBigDecimal()
                }

                println("Fatorial de ${vetor[y]} = ${fat.toString()}, executado pela thread ${Thread.currentThread().name} em ${System.currentTimeMillis()}")
            }
        }
    }

    Thread thread = new Thread(runnable)

    threads.add(thread)
}

for (Thread thread : threads) {
    thread.start()
}