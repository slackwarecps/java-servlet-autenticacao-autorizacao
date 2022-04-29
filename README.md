# java-servlet-autenticacao-autorizacao



Nesse Projeto conhecemos um novo recurso do mundo de Servlets, o javax.servlet.Filter. Os filtros realmente são muito úteis no dia a dia para diversas funções, então se lembre disso nos seus projetos web!

e Aprendemos que:

Um Filter e Servlet são bem parecidos

Comparado com Servlet, o Filter tem o poder de parar o fluxo

Para escrever um filtro, devemos implementar a interface javax.servlet.Filter
Para mapear o filtro, usamos a anotação @WebFilter ou o web.xml

Vários filtros podem funcionar numa cadeia (um chama o próximo, mas todos são independentes)

Para definir a ordem de execução, devemos mapear os filtros no web.xml

Um filtro recebe como parâmetro, do método doFilter, um ServletRequest e um ServletResponse
Ambos, ServletRequest e ServletResponse, são interfaces mais genéricas do que HttpServletRequest e HttpServletResponse

Para chamar o próximo filtro na cadeia, usamos o objeto FilterChain

https://json.org/example.html

https://github.com/google/gson


https://hc.apache.org/httpcomponents-client-5.1.x/



