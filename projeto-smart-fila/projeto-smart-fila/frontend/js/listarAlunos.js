async function listarAlunos() {
    const res = await fetch(URL_BASE);
    const alunos = await res.json();
    corpoTabela.innerHTML = '';
    alunos.forEach(a => {
        corpoTabela.innerHTML += `
            <tr>
                <td>${a.ra}</td>
                <td>${a.nome}</td>
                <td>${a.turma}</td>
                <td>
                    <button onclick="carregarParaEditar(${a.id})">Editar</button>
                    <button onclick="executarExclusao(${a.id})">Excluir</button>
                </td>
            </tr>`;
    });
}
window.onload = listarAlunos;